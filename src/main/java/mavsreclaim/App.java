package mavsreclaim;

import io.javalin.Javalin;

public class App {
    public static void main(String[] args) {
        Db.init();
        Javalin app = Javalin.create().start(7070);
        app.get("/", ctx -> ctx.result("hello"));
        app.get("/test", ctx -> ctx.result("Hello, but from a test page"));

        /* so like that app.get() above says if you run www.mavsreclaim.com/ serve the result Hello
            if we did app.get("/found_item" -> ctx.render("report.html"))
            that would say when someone hits www.mavsreclaim.com/found_item we redner the report forms html file.
            We dont have a real domain so itd be more like localhost:7070/found_item as the url but same same

            so download java 25 sdk and maven. if your not on windows i super recomend sdkman for managing java sdks.
            download maven

            To test: run "mvn compile exec:java"
            you should then open http:localhost:7070/ and see hello on the screen
            or go to http:localhost:7070/test and see the other result..

            you should also see a .db file appear in the root. that is the sqlite db that gets created on startup.
            *.db is in gitignore so you wont commit your local db. isnide Db.java is our db logic,
            and /resources/schema.sql is the schema being ran by Dbinit();
        */
    }
}
