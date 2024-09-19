@import exercise.dto.posts.BuildPostPage
@import exercise.dto.posts.EditPostPage
@import exercise.dto.posts.PostPage
@import exercise.repository.PostRepository
@import exercise.util.NamedRoutes
@param EditPostPage page


@template.layout.page(
content  = @`
    @if(page.getErrors() != null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif
`
)