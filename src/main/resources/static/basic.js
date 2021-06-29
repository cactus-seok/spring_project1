$(document).ready(function () {
    findAllPosts()
})

//post 생성 시간 기준 전체 조회
function findAllPosts() {
    $.ajax({
        type: 'GET',
        url: '/post',
        success: function (response) {
            for (let i = 0; i < response.length; i++) {
                let post = response[i];
                let tempHtml = getPosts(post);
                $('#ulTable').append(tempHtml);
            }
        },
        error: function () {
            alert("데이터를 조회하는데 실패 했습니다.")
        }
    })
}

// 새로운 POST 메인 화면에 뿌림
function getPosts(post) {
    return `<li>
                    <ul>
                        <li>${post.id}</li>
                        <li class="left" >${post.title}</li>
                        <li>${post.createdAt}</li>
                        <li>${post.username}</li>
                    </ul>
                </li>`
}



function getPostDetail(id) {
    window.location.href = 'post.html?id=' + id
}

// 포스트 저장
function savePost() {
    let title = $('#title').val()
    let username = $('#username').val()
    let contents = $('#contents').val()

    let post = {
        'title': title,
        'username': username,
        'contents': contents
    }

    if (!title) {
        alert("제목은 필수 값 입니다.")
        $('#title').focus()
    } else if (!username) {
        alert("작성자 필수 값 입니다.")
        $('#username').focus()
    } else if (!contents) {
        alert("본문은 필수 값 입니다.")
        $('#contents').focus()
    } else {
        $.ajax({
            type: 'POST',
            url: '/post',
            contentType: "application/json",
            data: JSON.stringify(post),
            success: function (response) {
                alert('게시글 등록이 완료되었습니다.')
                window.location.replace("/")
            },
            error: function () {
                alert('게시글 등록에 실패 했습니다.')
            }
        })
    }
}