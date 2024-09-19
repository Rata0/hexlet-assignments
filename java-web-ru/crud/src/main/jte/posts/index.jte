@import exercise.model.Post
@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@import javax.naming.Name

@param PostsPage page


@template.layout.page(
content  = @`
    <div class="container my-5">
        <h1 class="mb-4 text-center">List of posts</h1>

        @if(page.getPostList().isEmpty())
            <p>No posts have been added yet</p>
        @else
            <div class="row">
                @for(var post : page.getPostList())
                    <div class="col-md-6 mb-4">
                        <div class="card">
                            <div class="card-body">
                                <h2 class="card-title"><a href="${NamedRoutes.postPath(post.getId())}" class="text-decoration-none">${post.getName()}</a></h2>
                                <p class="card-text">${post.getBody()}</p>
                            </div>
                        </div>
                    </div>
                @endfor
            </div>
        @endif

        <nav aria-label="Page navigation">
            <ul class="pagination justify-content-center">
                <li class="page-item"><a class="page-link" href="${NamedRoutes.postsPath()}?page=${page.getPreviousPage()}">Previous</a></li>
                <li class="page-item"><a class="page-link" href="${NamedRoutes.postsPath()}?page=${page.getNextPage()}">Next</a></li>
            </ul>
        </nav>
    </div>
`
)
