import controller.Controller;
import view.InputView;
import view.ResultView;

public class Application {
    public static void main(String[] args) {
        try {
            Controller controller = new Controller(new InputView(), new ResultView());
            controller.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
