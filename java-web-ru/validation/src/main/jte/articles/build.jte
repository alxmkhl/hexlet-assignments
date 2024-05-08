@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(
content = @`
    @if(page.getErrors() != null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif
    <form action="/articles" method="post">
<%--        <input name="title" class="form-control form-control-lg" type="text" placeholder="course name" value=${page.getName()} >--%>
        <input type="text" name="title" value="${page.getName()}" />
        <br>
        <textarea name="content" class="form-control" id="exampleFormControlTextarea1" rows="3">${page.getDescription()}</textarea>
        <br>
        <button type="submit" class="btn btn-primary">Create</button>
    </form>
`
)
