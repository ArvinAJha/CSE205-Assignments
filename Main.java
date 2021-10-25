import com.apple.eawt.Application;

public class Main extends Application{

    public void start(Stage stage) throws Exception {

        stage.setTitle(WINTITLE);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args)
    }
}
