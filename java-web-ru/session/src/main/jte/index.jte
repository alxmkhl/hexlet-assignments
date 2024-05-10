@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(
content = @`

    <div class="mx-auto p-4 py-md-5">
        @if(page.getName() != null)
            <div>${page.getName().toString()}</div>
            <form action="${NamedRoutes.logoutPath()}" method="post">
                <input type="submit" class="btn btn-primary" value="Выйти" />
            </form>
        @else
            <form action="${NamedRoutes.buildSessionPath()}" method="post">
                <input type="submit" class="btn btn-primary" value="Войти" />
            </form>
        @endif
    </div>

`
)
