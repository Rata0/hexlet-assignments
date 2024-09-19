@import exercise.dto.posts.BuildPostPage
@import exercise.dto.posts.EditPostPage
@import exercise.dto.posts.PostPage
@import exercise.repository.PostRepository
@import exercise.util.NamedRoutes
@param EditPostPage page


@template.layout.page(
content  = @`
    <div class="container my-5">
        @if(page.getErrors() != null)
            <div class="alert alert-danger">
                <ul class="mb-0">
                    @for(var validator : page.getErrors().values())
                        @for(var error : validator)
                            <li>${error.getMessage()}</li>
                        @endfor
                    @endfor
                </ul>
            </div>
        @endif

        <form action="/posts/${page.getPost().getId()}" method="post" class="card p-4">
            <div class="form-group">
                <label for="name">Измени название поста</label>
                <input type="text" class="form-control" id="name" name="name" value="${page.getPost().getName()}">
            </div>
            <div class="form-group">
                <label for="body">Измени описание поста</label>
                <textarea class="form-control" id="body" name="body" rows="6" required>${page.getPost().getBody()}</textarea>
            </div>
            <button type="submit" class="btn btn-primary">Изменить</button>
        </form>
    </div>
`
)