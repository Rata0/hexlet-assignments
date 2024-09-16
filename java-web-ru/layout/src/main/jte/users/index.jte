@import exercise.Data
@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(welcome = null,
users = @`
    @for(var user: page.getUsers())
        <div class="col-md-4 mb-4" id="${user.getId()}">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">${user.getFirstName()} ${user.getLastName()}</h5>
                    <a href="/users/${user.getId()}" class="btn btn-primary">View User</a>
                </div>
            </div>
        </div>
    @endfor
`,
user = null)
