$(document).ready(function () {
    findAllPosts()
})

//post 생성 시간 기준 전체 조회
function findAllPosts() {
    $.ajax({
        type: 'GET',
        url: '/post',
        success: function (response) {
            console.log(response)
            for (let i = 0; i < response.length; i++) {
                let post = response[i];
                let tempHtml = addPosts(post)
                $('#blog-list').append(tempHtml)
            }
        },
        error: function () {
            alert("데이터를 조회하는데 실패 했습니다.")
        }
    })
}



// 새로운 POST 메인 화면에 뿌림
function addPosts(post) {
    return `<tr>
                <th>${post.id}</th>
                <td><a href="/detail.html?id=${post.id}">${post.title}</a>
                </td>
                <td>${post.username}</td>
                <td class="date">${post.createdAt}</td>
            </tr>`
}

function savePost() {

    post = {
        'title': $('#title').val(),
        'contents': $('#contents').val(),
        'username': $('#username').val(),
        'createdAt': $('#createdAt').val()
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
                console.log(response)
                alert('게시글 등록이 완료되었습니다.')
                window.location.replace("/")
            },
            error: function () {
                alert('게시글 등록에 실패 했습니다.')
            }
        })
    }
}

function getPostDetail(id) {
    window.location.href = 'post.html?id=' + id
}

let current_id = document.location.href.split("?id=")[1];

// 게시물 조회
function findOne(){
    $.ajax({
        type: 'GET',
        url: `/api/posts/${current_id}`,
        success: function(response){
            $('#title').text(response.title);
            $('#content').text(response.content);

        },
        error: function(e){
            alert("게시글을 조회할 수 없습니다.");
        }
    });
}