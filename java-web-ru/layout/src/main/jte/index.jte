@import exercise.Data
@import exercise.dto.users.UsersPage
@param UsersPage usersPage

@template.layout.page(welcome = @`
    <div class="jumbotron">
        <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
    </div>
`,
users = null,
user = null)
