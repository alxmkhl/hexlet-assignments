@import gg.jte.Content
@param Content content

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Website</title>
</head>
<header class="bg-dark text-white p-3 fixed-top">
    <h6>
        <a href="/users">Users</a>
    </h6>
</header>
<body style="padding-top: 100px;">

${content}

<footer style="position: fixed; bottom: 0; width: 100%; background: #333; color: #fff; text-align: center; padding: 10px;">
    © 2024 alxmkh, Inc
</footer>
</body>
</html>