@import exercise.dto.users.UserPage
@param UserPage page

<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>User with id: ${page.getUser().getId()}</title>
</head>
<body>
<ul class="list-group">
    <li class="list-group-item">${page.getUser().getId()}</li>
    <li class="list-group-item">${page.getUser().getFirstName()}</li>
    <li class="list-group-item">${page.getUser().getLastName()}</li>
    <li class="list-group-item">${page.getUser().getEmail()}</li>
</ul>
</body>
</html>

