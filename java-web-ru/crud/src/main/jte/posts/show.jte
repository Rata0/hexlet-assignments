@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

@template.layout.page(
    content  = @`
        <div class="container my-5">
            <div class="card">
                <div class="card-body">
                    <h1 class="card-title">${page.getPost().getName()}</h1>
                    <p class="card-text">${page.getPost().getBody()}</p>
                </div>
            </div>

            <div class="mt-4">
                <a href="${NamedRoutes.postsPath()}" class="btn btn-primary">Back to posts</a>
            </div>
        </div>
    `
)