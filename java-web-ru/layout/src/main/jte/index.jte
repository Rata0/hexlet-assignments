@import exercise.dto.users.UsersPage
@param UsersPage usersPage

@template.layout.page(welcome = @`
    <div class="jumbotron">
        <p class="lead">This block contains information about users, as well as a list of users.</p>
    </div>
`,
users = null,
user = null)
