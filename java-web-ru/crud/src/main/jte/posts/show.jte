@import exercise.dto.posts.PostPage
@param PostPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <a href="/posts">Back</a>
            <div>
                ${page.getPost().getId()}
            </div>
            <div>
                ${page.getPost().getName()}
            </div>
            <div>
                ${page.getPost().getBody()}
            </div>
        </main>
    </div>
`
)
