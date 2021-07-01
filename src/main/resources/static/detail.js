
$(document).ready(function () {
    getPostId()
})

function getPostId() {
    let param = document.location.href.split("?id=")
    let id = param[1]
    getPostDetail(id)
}

function getPostDetail(id) {
    $.ajax({
        type: 'GET',
        url: `/post/${id}`,
        success: function (response) {
            console.log(response+"response")
            let tempHtml = getDetailHtml(response)
            $('#detail-page').append(tempHtml)
        },
        error: function () {
            alert("데이터를 조회하는데 실패 했습니다.")
        }
    })
}

function getDetailHtml(post) {
    return `<div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">제목</span>
        </div>
        <div class="form-control" id="title">
            ${post.title}
        </div>


        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">내용</span>
            </div>
            <div class="form-control" id="contents">
                ${post.contents}
            </div>
        </div>

        <div class="info_bottom">
            <div class="writer">작성자 : ${post.username}</div>
            <div class="date">작성일 : ${post.createdAt}</div>
        </div>
    </div>`
}