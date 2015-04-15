import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;

public class MailReader extends Application {

    private ObservableList<Message> inboxList;
    private ObservableList<Message> flaggedList;
    private ObservableList<Message> trashList;
    private ObservableList<Message> currentBoxList;
    private ObservableList<String> message;
    private ObservableList<String> boxName;
    private Server server = new Server();
    private Mailbox inbox;
    private Mailbox flagged;
    private Mailbox trash;
    private Mailbox currentBox;
    private Message currentMessage;
    private int currentIdx = 0;

    @Override
    public void start(Stage stage) {

        this.currentBox = new Mailbox();
        this.initBoxes();
        this.updateList();

        this.currentBoxList = FXCollections.observableArrayList();
        this.currentBoxList.setAll(this.inboxList);

        this.boxName = FXCollections.observableArrayList();
        this.boxName.setAll("Inbox");

        this.message = FXCollections.observableArrayList();
        this.updateMessage();

        ListView<Message> currentMessages =
                                          new ListView<Message>(currentBoxList);
        ListView<String> curMessage = new ListView<String>(message);
        ListView<String> aBoxName = new ListView<String>(boxName);

        BorderPane border = new BorderPane();
        border.setPadding(new Insets(20, 0, 20, 20));

        Button btnFlag = new Button("Flag");
        btnFlag.setOnAction(e -> {
                if (this.currentBox.getMessages().size() > 0
                    && this.currentIdx
                    < this.currentBox.getMessages().size()) {
                    Message m = this.currentBox.getMessage(this.currentIdx);
                    this.currentBoxList.remove(m);
                    this.currentBox.remove(m);
                    this.flagged.add(m);
                    this.updateList();
                } else {
                    this.currentIdx = this.currentBox.getMessages().size() - 1;
                    this.updateMessage();
                }
            });

        Button btnDelete = new Button("Delete");
        btnDelete.setOnAction(e -> {
                if (this.currentBox.getMessages().size() > 0
                    && this.currentIdx < this.currentBox.getMessages().size()) {
                    Message m = this.currentBox.getMessage(this.currentIdx);
                    this.currentBoxList.remove(m);
                    this.currentBox.remove(m);
                    this.trash.add(m);
                    this.updateList();
                    this.updateMessage();
                } else {
                    this.currentIdx = this.currentBox.getMessages().size() - 1;
                    this.updateMessage();
                }
            });

        Button btnRefresh = new Button("Refresh");
        btnRefresh.setOnAction(e -> {

                this.inbox.removeAll();
                this.inbox.add(this.server.getInbox().getMessages());

                this.trash.removeAll();
                this.trash.add(this.server.getTrash().getMessages());

                this.flagged.removeAll();
                this.flagged.add(this.server.getFlagged().getMessages());

                this.updateList();

                this.currentBox = this.inbox;
                this.currentBoxList.setAll(this.inboxList);
                this.currentIdx = 0;
                this.boxName.setAll("Inbox");
            });

        Button btnUp = new Button("Up");
        btnUp.setOnAction(e -> {
                if (this.currentIdx > 0) {
                    this.currentIdx -= 1;
                }
                this.updateMessage();
            });

        Button btnDown = new Button("Down");
        btnDown.setOnAction(e -> {
                if (this.currentIdx
                    < this.currentBox.getMessages().size() - 1) {
                    this.currentIdx += 1;
                }
                this.updateMessage();
            });

        Button btnFlagged = new Button("Flagged");
        btnFlagged.setOnAction(e -> {
                this.currentIdx = 0;
                this.currentBoxList.setAll(this.flaggedList);
                this.currentBox = this.flagged;
                this.boxName.setAll("Flagged");
                this.updateList();
            });

        Button btnTrash = new Button("Trash");
        btnTrash.setOnAction(e -> {
                this.currentIdx = 0;
                this.currentBoxList.setAll(this.trashList);
                this.currentBox = this.trash;
                this.boxName.setAll("Trash");
                this.updateList();
            });

        Button btnInbox = new Button("Inbox");
        btnInbox.setOnAction(e -> {
                this.currentIdx = 0;
                this.currentBoxList.setAll(this.inboxList);
                this.currentBox = this.inbox;
                this.boxName.setAll("Inbox");
                this.updateList();
            });

        btnFlag.setMaxWidth(Double.MAX_VALUE);
        btnDelete.setMaxWidth(Double.MAX_VALUE);
        btnFlagged.setMaxWidth(Double.MAX_VALUE);
        btnTrash.setMaxWidth(Double.MAX_VALUE);
        btnInbox.setMaxWidth(Double.MAX_VALUE);

        VBox actionButtons = new VBox();
        actionButtons.setSpacing(10);
        actionButtons.setPadding(new Insets(0, 20, 10, 20));
        actionButtons.getChildren().addAll(btnUp, btnDown,
                                           btnFlag, btnDelete, btnRefresh);

        HBox boxButtons = new HBox();
        boxButtons.setSpacing(10);
        boxButtons.setPadding(new Insets(0, 20, 10, 20));
        boxButtons.getChildren().addAll(btnInbox, btnFlagged, btnTrash);
        HBox boxes = new HBox();
        boxes.getChildren().addAll(currentMessages);
        HBox messageBody = new HBox();
        messageBody.getChildren().addAll(curMessage);
        HBox body = new HBox();
        body.getChildren().addAll(aBoxName, boxes, messageBody);
        VBox reader = new VBox();
        reader.getChildren().addAll(boxButtons, body, actionButtons);

        Scene scene = new Scene(reader);
        stage.setScene(scene);
        stage.setTitle("MailReader");
        stage.show();

    }

    public void updateList() {

        this.inboxList = FXCollections.observableArrayList();
        for (Message m: this.inbox.getMessages()) {
            this.inboxList.add(m);
        }

        this.flaggedList = FXCollections.observableArrayList();
        for (Message m: this.flagged.getMessages()) {
            this.flaggedList.add(m);
        }

        this.trashList = FXCollections.observableArrayList();
        for (Message m: this.trash.getMessages()) {
            this.trashList.add(m);
        }

        this.updateMessage();
    }

    private void initBoxes() {
        this.inbox = new Mailbox("Inbox");
        this.inbox.add(this.server.getInbox().getMessages());

        this.flagged = new Mailbox("Flagged");
        this.flagged.add(this.server.getInbox().getMessages());

        this.trash = new Mailbox("Trash");
        this.trash.add(this.server.getInbox().getMessages());

        this.currentBox = this.inbox;
    }

    private void updateMessage() {
        if (this.currentBox.getMessages().size() > 0) {
            this.currentMessage = this.currentBox.getMessage(this.currentIdx);
            this.message.setAll(this.currentMessage.toString()
                                + "\n" + this.currentMessage.getDate()
                                + "\n" + this.currentMessage.getMessage());
        } else {
            this.message.setAll();
        }
    }

}
