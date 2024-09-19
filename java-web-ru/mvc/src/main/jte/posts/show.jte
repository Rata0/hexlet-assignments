@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

@template.layout.page(
    content = @`
        <div class="container my-5">
            <div class="card">
                <div class="card-body">
                    <h1 class="card-title">${page.getPost().getName()}</h1>
                    <p class="card-text">${page.getPost().getBody()}</p>
                    <a href="/posts/${page.getPost().getId()}/edit" class="btn btn-primary">Редактировать пост</a>
                </div>
            </div>
        </div>
    `
)
