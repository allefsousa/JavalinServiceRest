package controler;
import com.fasterxml.jackson.databind.util.JSONPObject;
import dao.UserDao;
import io.javalin.http.Handler;
import model.Language;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class UserController {



    public static Handler fetchAllUsernames = ctx-> {
        UserDao dao = UserDao.instance();
        ctx.json(dao.getAllUsernames());
        ctx.status(200);
    };

    public static Handler fetchById= ctx-> {
        int id = Integer.parseInt(Objects.requireNonNull(ctx.pathParam("id")));
        UserDao dao = UserDao.instance();
        Language user = dao.getUserById(id).get();
        if (user == null) {
            ctx.html("Not Found");
            ctx.status(404);


        } else {
            ctx.json(user);
            ctx.status(200);

        }
    };
}
