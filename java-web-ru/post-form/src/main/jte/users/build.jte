@template.layout.page(
content = @`
    <h1>Создание пользователя</h1>
    <form method="post" action="/users">
        <div class="form-group">
            <label for="exampleInputEmail1">First name</label>
            <input name="firstName" class="form-control" type="text" placeholder="First name">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">Last name</label>
            <input name="lastName" class="form-control" type="text" placeholder="Last name">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                   placeholder="Enter email">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>

`
)
