@import exercise.dto.users.UserPage
@param UserPage page


@template.layout.page(
content = @`
    <ul class="list-group">
        <li class="list-group-item">${page.getUser().getId()}</li>
        <li class="list-group-item">${page.getUser().getFirstName()}</li>
        <li class="list-group-item">${page.getUser().getLastName()}</li>
        <li class="list-group-item">${page.getUser().getEmail()}</li>
    </ul>
`
)