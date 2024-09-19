package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import java.util.List;

public class PostsController {

    // BEGIN
    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        Post post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Page not found."));

        PostPage page = new PostPage(post);
        ctx.render("posts/show.jte", model("page", page));
    }

    public static void index(Context ctx) {
        int pageNumber = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        int pageSize = 5;
        List<Post> posts = PostRepository.getEntities();
        int totalPosts = posts.size();
        int totalPages = (int) Math.ceil((double) totalPosts / pageSize);
        int currentPage = Math.max(1, Math.min(pageNumber, totalPages));
        int start = (currentPage - 1) * pageSize;
        int end = Math.min(start + pageSize, totalPosts);
        List<Post> pageData = posts.subList(start, end);

        int previousPage = currentPage > 1 ? currentPage - 1 : 1;
        int nextPage = currentPage < totalPages ? currentPage + 1 : totalPages;

        PostsPage page = new PostsPage(pageData, previousPage, nextPage);
        ctx.render("posts/index.jte", model("page", page));
    }


    // END
}
