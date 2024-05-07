@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <form action="/users" method="get">
<%--        <input type="search" required name="term">--%>
<%--        <input type="submit" value="Find user">--%>
        <div class="row g-3">
            <div class="col">
                <input type="search" class="form-control" placeholder="First name" aria-label="First name" required name="term">
            </div>
            <div class="col">
                <button type="submit" class="btn btn-primary">Find user</button>
            </div>
        </div>
    </form>


    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
        </tr>
        </thead>
        @if(page.getTerm() == null)
            @for(var user : page.getUsers())
                <tbody>
                <tr>
                    <th scope="row">${user.getId()}</th>
                    <td>${user.getFirstName() + " " + user.getLastName()}</td>
                    <td>@${user.getEmail()}</td>
                </tr>

                </tbody>
            @endfor
        @else
            @for(var user : page.getUsers())
                @if(user.getFirstName().toLowerCase().startsWith(page.getTerm().toLowerCase()))
                    <tbody>
                    <tr>
                        <th scope="row">${user.getId()}</th>
                        <td>${user.getFirstName() + " " + user.getLastName()}</td>
                        <td>@${user.getEmail()}</td>
                    </tr>
                    </tbody>
                @endif
            @endfor
        @endif


    </table>
`
)
