function searchBlog() {
    let nameBlog = $("#searchBlog").val();
    $.ajax({
        url: "/api/blogs/search",
        data: {
            blogName: nameBlog
        },
        type: "get",
        dataType: "json",
        success: function (temp) {
            let blogList = temp.content; // dùng khi list là page
            console.log(blogList);
            console.log(temp)
            let result = '';
            for (let i = 0; i < blogList.length; i++) {
                result += `
                    <div class="card col-md-3">
                        <img src="${blogList[i].image}" class="card-img-top" width="200px" height="150px" alt="...">
                        <div class="card-body">
                            <h5 class="card-title text text-primary">name:  ${blogList[i].name}</h5>
                            <h5 class="card-title text text-success">category:  ${blogList[i].category.name}</h5>
                            <p class="card-text">describe: ${blogList[i].describe}</p>
                            <a href="/blog/view/{id}(id=${blogList[i].id})" class="btn btn-primary">View</a>
                            <a href="/blog/delete/{id}(id=${blogList[i].id})" class="btn btn-danger">Delete</a>
                            <a href="/blog/edit/{id}(id=${blogList[i].id})" class="btn btn-warning">Edit</a>
                        </div>
                    </div>`
                // console.log(result)
                $("#result").html(result);
            }
        }
    });
}

// function page() {
//     let size = $("#check-size").val();
//     $.ajax({
//         url: "/api/blogs/list",
//         data: {
//             limit: size
//         },
//         type: "get",
//         dataType: "json",
//         success: function (blogList) {
//             // let blogList = temp.content; // dùng khi list là page
//             console.log(blogList)
//
//             if (blogList != null) {
//                 document.getElementById("check-size").value = blogList.length;
//             }
//
//             let result = '';
//
//             for (let i = 0; i < blogList.length; i++) {
//                 result += `
//                     <div class="card col-md-3">
//                         <img src="${blogList[i].image}" class="card-img-top" width="200px" height="150px" alt="...">
//                         <div class="card-body">
//                             <h5 class="card-title text text-primary">name:  ${blogList[i].name}</h5>
//                             <h5 class="card-title text text-success">category:  ${blogList[i].category.name}</h5>
//                             <p class="card-text">describe: ${blogList[i].describe}</p>
//                             <a href="/blog/view/{id}(id=${blogList[i].id})" class="btn btn-primary">View</a>
//                             <a href="/blog/delete/{id}(id=${blogList[i].id})" class="btn btn-danger">Delete</a>
//                             <a href="/blog/edit/{id}(id=${blogList[i].id})" class="btn btn-warning">Edit</a>
//                         </div>
//                     </div>`;
//
//                 console.log(result)
//                 $("#result").html(result);
//             }
//         }
//     });
// }

// Load more
let page = 0;
window.onload = function loadFirstPage() {
    $.ajax({
        type: 'GET',
        url: `/api/blogs?page=${page}`,
        success: function (temp) {
            page = temp.number;
        }
    })
}


function loadMore() {
    page++;
    $.ajax({
        type: 'GET',
        url: `/api/blogs?page=${page}`,
        success: function (temp) {
            let blogList = temp.content;
            let result = '';
            for (let i = 0; i < blogList.length; i++) {
                result += `
                    <div class="card col-md-3">
                        <img src="${blogList[i].image}" class="card-img-top" width="200px" height="150px" alt="...">
                        <div class="card-body">
                            <h5 class="card-title text text-primary">name:  ${blogList[i].name}</h5>
                            <h5 class="card-title text text-success">category:  ${blogList[i].category.name}</h5>
                            <p class="card-text">describe: ${blogList[i].describe}</p>
                            <a href="/blog/view/{id}(id=${blogList[i].id})" class="btn btn-primary">View</a>
                            <a href="/blog/delete/{id}(id=${blogList[i].id})" class="btn btn-danger">Delete</a>
                            <a href="/blog/edit/{id}(id=${blogList[i].id})" class="btn btn-warning">Edit</a>
                        </div>
                    </div>`;
            }
            $("#result").append(result);
        }
    })
}
