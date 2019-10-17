import controler.UserController;
import io.javalin.Javalin;

import java.util.NoSuchElementException;

import static io.javalin.apibuilder.ApiBuilder.get;

public class HelloWorld {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(getHerokuAssignedPort());

        app.routes(() -> {
            get("/", ctx -> ctx.result("Hello World"));
            get("/toplanguage", UserController.fetchAllUsernames);
            get("/toplanguage/:id", UserController.fetchById);

        });
        app.exception(NoSuchElementException.class,((e, context) -> {
            context.result("ID Nao encontrado !");
            context.status(404);
        }));




    }
    private static int getHerokuAssignedPort() {
        String herokuPort = System.getenv("PORT");
        if (herokuPort != null) {
            return Integer.parseInt(herokuPort);
        }
        return 7000;
    }
}
