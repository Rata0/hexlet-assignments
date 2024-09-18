@template.layout.page(
    content = @`
        <form action="/user" method="post">
          <div class="form-group">
            <label for="exampleInputEmail1">Имя</label>
            <input type="email" class="form-control" aria-describedby="emailHelp" name="firstName" placeholder="Введите имя">
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Фамилия</label>
            <input type="password" class="form-control" name="lastName" placeholder="Введите фамилию">
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Почта</label>
            <input type="password" class="form-control" name="email" placeholder="Введите почту">
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Пароль</label>
            <input type="password" class="form-control" name="password" placeholder="Введите пароль">
          </div>

          <button type="submit" class="btn btn-primary">Отправить</button>
        </form>
    `
)