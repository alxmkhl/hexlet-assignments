@import exercise.dto.users.UsersPage
@param UsersPage page


@template.layout.page(
content = @`
<table class="table">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">First name</th>
        <th scope="col">Last name</th>
        <th scope="col">Email</th>
    </tr>
    </thead>
    <tbody>
    @for(var user : page.getUsers())
        <tr>
            <th scope="row">
                <a href="/users/${user.getId()}">${user.getId()}</a>
            </th>
            <td>${user.getFirstName()}</td>
            <td>${user.getLastName()}</td>
            <td>${user.getEmail()}</td>
        </tr>
    @endfor
    </tbody>
</table>
`
)



