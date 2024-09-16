@import exercise.Data
@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(welcome = null,
users = null,
user = @`
    <div class="card">
        <div class="card-body">
            <h3 class="card-title">${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h3>
            <p class="card-text"><b>Email:</b> ${page.getUser().getEmail()}</p>
        </div>
    </div>
`)
