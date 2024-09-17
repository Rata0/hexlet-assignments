@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        <h1>User list </h1>
        <form action="/users" method="GET">
            <input type="search" name="term" value="${page.getTerm()}" />
            <input type="submit" value="Search" />
        </form>

        @if (page.getUsers().isEmpty())
            <p1>Нет пользователя</p1>
        @endif

         @for(var user : page.getUsers())
            <div class="card">
              <h5 class="card-header">User card id(${user.getId()}) </h5>
              <div class="card-body">
                <h5 class="card-title">${user.getFirstName()} ${user.getLastName()}</h5>
                <p class="card-text">Email: ${user.getEmail()}</p>
                <a href="#" class="btn btn-primary">Read more</a>
              </div>
            </div>
         @endfor
    `
)
