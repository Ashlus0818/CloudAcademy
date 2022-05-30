<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous" />
</head>
<body>

	<div class="container">
		<p />
		<div class="row justify-content-center">
			<div class="col-9">
				<div class="card">
					<div class="card-header">
						<h1>待辦事項</h1>
					</div>
					<div class="card-body">
						<form class="form" method="post" action="insert">
							<%-- 					<form:errors path="context"/> --%>
							<div class="input-group">
								<textarea name="context" class="form-control"></textarea>
							</div>
							<input type="submit" value="送出">
						</form>
					</div>
				</div>
			</div>
		</div>

		<div class="row justify-content-center">
			<div class="col-9">
				<div class="card">
					<div class="card-header">
						最新訊息(時間) <span><fmt:formatDate
								pattern="yyyy-MM-dd HH:mm:ss EEEE" value="${lastMessage.added}" /></span>
					</div>
					<div class="card-body">
						<nav>
							<div class="nav nav-tabs" id="nav-tab" role="tablist">
								<button class="nav-link active" id="nav-home-tab"
									data-bs-toggle="tab" data-bs-target="#nav-home" type="button"
									role="tab" aria-controls="nav-home" aria-selected="true">Home</button>
								<button class="nav-link" id="nav-profile-tab"
									data-bs-toggle="tab" data-bs-target="#nav-profile"
									type="button" role="tab" aria-controls="nav-profile"
									aria-selected="false">Profile</button>
							</div>
						</nav>
						<div class="tab-content" id="nav-tabContent">
							<div class="tab-pane fade show active" id="nav-home"
								role="tabpanel" aria-labelledby="nav-home-tab">
								<c:forEach var="bTask" items="${bTaskes}">
									<form id="form${bTask.id}" action="" method="post">
										<table>
											<tr>
												<td>${bTask.id}.${bTask.context}<input type="hidden" name="taskid" value="${bTask.id}"/>
													<div class="text-center">
														<input class="btn btn-primary" id="delete${bTask.id}"
															type="button" value="移除"
															onclick="deleteAlert(${bTask.id})" /> <input
															class="btn btn-primary" id="complete${bTask.id}"
															type="button" value="完成"
															onclick="complete(${bTask.id})" />
													</div>
										</table>
									</form>
								</c:forEach>
							</div>
							<div class="tab-pane fade" id="nav-profile" role="tabpanel"
								aria-labelledby="nav-profile-tab">
								<table>
									<c:forEach var="aTask" items="${aTaskes}">
										<tr>
											<td>${aTask.id}
										<tr>
											<td>${aTask.context}
									</c:forEach>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>



	</div>

	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous">
		
	</script>
	<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>
	<script>
	function deleteAlert(count){
		var form="form"+count;
		console.log(count);
		document.getElementById(form).action = 'delete';
		document.getElementById(form).submit();
	};
	</script>
</body>
</html>