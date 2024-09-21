package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.model.User;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import io.javalin.http.Context;

public class SessionsController {
    // BEGIN
    public static void index(Context ctx) {
        Object user = ctx.sessionAttribute("user");
        MainPage page = new MainPage(user);
        ctx.render("index.jte", model("page", page));
    }

    public static void build(Context ctx) {
        LoginPage page = new LoginPage("", "");
        ctx.render("build.jte", model("page", page));
    }

    public static void create(Context ctx) {
        String name = ctx.formParam("name");
        String password = ctx.formParam("password");

        User user = UsersRepository.findByName(name).orElse(null);

        if (user != null && user.getPassword().equals(encrypt(password))) {
            ctx.sessionAttribute("user", user.getName());
            ctx.redirect("/");
        } else {
            String errorMessage = "Wrong username or password";
            LoginPage page = new LoginPage(name, errorMessage);
            ctx.render("build.jte", model("page", page));
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("user", null);
        ctx.redirect("/");
    }
    // END
}
