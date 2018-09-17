<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' id='kboard-skin-thumbnail-css' href='/airport/resources/common/css/comments.css' type='text/css' media='all' />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		
		// 댓글 삽입 Ajax
		$("#insertcmt").click(function(){
			cmttxt = $("#cmttxt").val();
			empno = "관리자";
			boardno = $("#boardno").val();
			
			$.ajax({
				url:"/airport/erp/cmt/noticewrite.do",
				type:"get",
				data:{
					"boardno":boardno,
					"empno":empno,
					"cmttxt":cmttxt
				},
				success:function(list){
					$("#cmttxt").val('');
					cmtlist="";
					for (var i = 0; i < list.length; i++) {
						cmtlist = cmtlist + "<ul><li itemscope itemtype='http://schema.org/Comment' class='kboard-comments-item'><div class='comments-list-username'>"
									+ list[i].empno + 
									"</div><div class='comments-list-create'>"
									+ list[i].cmtdate + 
									"</div><div class='comments-list-content'>"
									+ list[i].cmttxt +
									"</div><div class='comments-list-controller'><div class='right'>" +
									"<a type='button' id='deletebtn' data_num="+list[i].cmtno+" href='#' class='comments-button-action comments-button-delete onclick='return confirm('삭제 하시겠습니까?')' title='삭제'>삭제</a></div></div></li></ul>";
						$("#deletebtn").attr("href", "https://www.naver.com");			
					}
				$("#cmtlist").empty();
				$("#cmtlist").append(cmtlist);
				
				// 댓글 삭제 Ajax
				$("#deletebtn").on("click", function(){
					var num = $(this).attr('data_num'); 
					$.ajax({
						url:"/bigdataShop/product/comment/delete.do",
						type:"get",
						data:{
							"cmt_no":cmt_no,
							"prd_no":prd_no,
						},
						success:function(list){
							alert("삭제완료");
						}
					});
				});
				}
			});
		});
	});
	</script>
</head>
<body>
	<div class="content">
		<div class="container-fluid">
			<div class="col-md-12">
				<div class="card">
					<div class="card-header card-header-primary">
						<h4 class="card-title">공지사항</h4>
						<input type="hidden" id="boardno" value="${post.boardno}">
					</div>
					<div class="card-body">
						<div>
							<h4>${post.title}</h4>
							<hr />
							<div class="row">
								<span class="col-md-3"><label>작성자</label> ${post.empno}</span> <span
									class="col-md-3"><label>작성일</label>${post.boarddate}</span> <span
									class="col-md-3"><label>조회수</label>${post.hits}</span>
							</div>
							<hr />
							<div>
								<div>
									<label>내용</label>
								</div>
								<div style="height: 300px">
									<p>${post.txt}</p>
								</div>
							</div>
						</div>
						<div class="kboard-comments-area">
							<div id="kboard-comments-1851" class="kboard-comments-default">
								<div class="kboard-comments-wrap">
									<!-- 댓글 리스트 시작 -->
									${cmt }
									<div id="kboard-comments-1851" class="kboard-comments-default">
										<div class="kboard-comments-wrap">
											<div class="comments-header">
												<div class="comments-count">
													전체 <span class="comments-total-count" id="cmtcount">
													1
													</span>
												</div>
												<hr />
											</div>
											<div class="comments-list" id="cmtlist">
													<ul>
														<li class="kboard-comments-item">
															<div class="comments-list-username">id</div>
															<div class="comments-list-create">20180909</div>
															<div class="comments-list-content">코멘트내용</div>
															<div class="comments-list-controller">
																<div class="right">
																	<a type="button" class="deletebtn" href="#">삭제</a> 
																</div>
															</div>
														</li>
													</ul>
					<c:forEach var="comment" items="${cmt}">
					<ul>
						<li class="kboard-comments-item">
							<div class="comments-list-username">
								${comment.empno }</div>
							<div class="comments-list-create">
								${comment.cmtdate }</div>
							<div class="comments-list-content">
									${comment.cmttxt }</div>
							<div class="comments-list-controller">
								<div class="right">
									<a type="button" href="#"
										class="comments-button-action comments-button-delete"
										onclick="return confirm('삭제 하시겠습니까?');" title="삭제" id="deletecmt">삭제</a>
								</div>
							</div>
						</li>
					</ul>
				</c:forEach>
											</div>
											<form id="cmtform" method="post">
												<div class="kboard-comments-form">
													<div class="comments-field">
														<textarea name="cmttxt" id="cmttxt"
															placeholder="댓글을 입력하세요." style="color: black;"></textarea>
													</div>
													<div class="comments-submit-button">
														<input class="btn" type="submit" style="background-color:#9c27b0;"value="입력" id="insertcmt">
													</div>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
						<hr />
						<a class="pull-right" href="/airport/erp/noticedelete.do?boardno=${post.boardno}"><i class="material-icons">delete</i>삭제</a>
						<a class="pull-right" href="/airport/erp/noticeupdate.do?boardno=${post.boardno}"><i class="material-icons">edit</i>수정</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>