@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <div><a href="/posts?page=${page.getPageNumber()-1 > 0 ? page.getPageNumber()-1 : 1}">back</a></div>
            <div><a href="/posts?page=${page.getPageNumber()+1}">next</a></div>
            <br>
            @for(var post : page.getPosts())
                <a href="/posts/${post.getId()}">${post.getId()}</a>
                <div>${post.getName()}</div>
                <div>${post.getBody()}</div>
            @endfor
        </main>
    </div>
`
)
