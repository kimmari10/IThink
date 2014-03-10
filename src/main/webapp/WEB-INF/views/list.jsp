<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>:::::::::::::::::::::</title>
<link rel="stylesheet"	href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<!-- <link rel="stylesheet"	href="css/jqueryui.css"> -->
<link rel="stylesheet"	href="css/style.css">
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="js/jqueryui.js"></script>
<script type="text/javascript" charset="utf-8" src="js/confirm.js"></script>

</head>
<body>
	<h1>Post in my Brain</h1>
	
	<div class="dialog1" title="Todo">
		<form action="addTab1Proc" method="post" onSubmit="return sub()">
			<fieldset>
				<legend>Add Form</legend>
				
				<label for="title">제목</label> 
				<input type="text"	name="title" style="width:227px"><br />
				 
				<label for="content">내용</label>
				<textarea name="content" cols="23" rows="10"></textarea><br />

				<!-- <label for="file">첨부파일</label>
				<input type="file" name="file"  /><br /> -->
				
				<label for="title">기한</label> 
				<input type="date" name="dday"> 
				<input type="submit" value="Add">
			</fieldset>
		</form>
	</div>
	<div class="dialog2" title="Tofix">
		<form action="addTab2Proc" method="post">
			<fieldset>
				<legend>Add Form</legend>
				
				<label for="title">제목</label> 
				<input type="text"	name="title" style="width:227px"><br />
				 
				<label for="content">내용</label>
				<textarea name="content" cols="23" rows="10"></textarea><br />

				<input type="submit" value="Add">
			</fieldset>
		</form>
	</div>
	<div class="dialog3" title="Sigh">
		<form action="addTab3Proc" method="post">
			<fieldset>
				<legend>Add Form</legend>
				
				<label for="title">제목</label> 
				<input type="text"	name="title" style="width:227px"><br />
				 
				<label for="content">내용</label>
				<textarea name="content" cols="23" rows="10"></textarea><br />
				<input type="submit" value="Add">
			</fieldset>
		</form>
	</div>
	<div class="dialog4" title="Song">
		<form action="addTab4Proc" method="post">
			<fieldset>
				<legend>Add Form</legend>
				
				<label for="title">제목</label> 
				<input type="text"	name="title" style="width:227px"><br />
				
				<label for="singer">가수</label> 
				<input type="text"	name="singer" style="width:227px"><br />
				 
				<label for="memo">메모</label>
				<textarea name="memo" cols="23" rows="10"></textarea><br />

				<input type="submit" value="Add">
			</fieldset>
		</form>
	</div>
	<div class="dialog5" title="Files" >
		<form action="addTab5Proc" method="post" enctype="multipart/form-data">
			<fieldset>
				<legend>Add Form</legend>
				
				<label for="title">제목</label> 
				<input type="text"	name="title" style="width:227px"><br />
				 
				<label for="content">내용</label>
				<textarea name="content" cols="23" rows="10"></textarea><br />

				<label for="file">첨부파일</label>
				<input type="file" name="file"  /><br />
				
				<input type="submit" value="Add">
			</fieldset>
		</form>
	</div>
	
	
	<button id="btnClose">목록접기</button>

	<!-- 탭부분 -->
	<div id="tabs">
		<ul>
			<li><a href="#tabs-1">해야할일(${tab1cnt })</a> <span	class="ui-icon ui-icon-close" role="presentation">Remove Tab</span></li>
			<li><a href="#tabs-2">수정해나갈점(${tab2cnt })</a> <span	class="ui-icon ui-icon-close" role="presentation">Remove Tab</span></li>
			<li><a href="#tabs-3">푸념(${tab3cnt })</a> <span class="ui-icon ui-icon-close" role="presentation">Remove Tab</span></li>
			<li><a href="#tabs-4">노래(${tab4cnt })</a> <span class="ui-icon ui-icon-close" role="presentation">Remove Tab</span></li>
			<li><a href="#tabs-5">자료실(${tab5cnt })</a> <span	class="ui-icon ui-icon-close" role="presentation">Remove Tab</span></li>
		</ul>

	<!-- 할일 -->
		<div id="tabs-1">
		<button id="add_tab1">+</button>
		
		<c:forEach var="n" items="${tab1 }">
			<div class="accordion">
				<div>	${n.title }<div>${n.dueday }</div></div>
				<div>
					<p>${n.content }</p>
					<div><div class="regdate">${n.regdate }</div>${n.dueday }</div>
					<c:if test="${empty n.succday }">
						<div class="done"><a href="tab1DoneProc?seq=${n.seq }">Be Done now!</a></div>
						<div><a href="delProc?seq=${n.seq }&tab=1">X</a></div>
					</c:if>
					<c:if test="${not empty n.succday }"><div>${n.succday } 에 완료</div></c:if>
					
				</div>
			</div>
		</c:forEach>
		</div>


		<!-- 고칠거 -->
		<div id="tabs-2">
		<button id="add_tab2">+</button>
		<c:forEach var="n" items="${tab2 }">
			<div class="accordion">
				<div>	${n.title }</div>
				<div>
					<p>${n.content }</p>
					<div class="regdate">${n.regdate }</div>
					<c:if test="${empty n.succday }">
						<div class="done"><a href="tab2DoneProc?seq=${n.seq }">Be Done now!</a></div>
						<div><a href="delProc?seq=${n.seq }&tab=2">X</a></div>
					</c:if>
					<c:if test="${not empty n.succday }"><div>${n.succday } 에 완료</div></c:if>
					
				</div>
			</div>
		</c:forEach>
		</div>
		
		
		<!-- 푸념 -->
		<div id="tabs-3">
		<button id="add_tab3">+</button>
		<c:forEach var="n" items="${tab3 }">
			<div class="accordion">
				<div>${n.title }</div>
				<div>${n.content }
					<div class="regdate">${n.regdate }</div>
					<div><a href="delProc?seq=${l.seq }&tab=3">X</a></div>
				</div>
			</div>
		</c:forEach>
		</div>
		
		<!-- 노래 -->
		<div id="tabs-4">
		<button id="add_tab4">+</button>
		<c:forEach var="n" items="${tab4 }">
			<div class="accordion">
				<div>${n.title } - ${n.singer }</div>
				<div>${n.memo }
					<div><a href="delProc?seq=${n.seq }&tab=4">X</a></div>
				</div>
				
			</div>
		</c:forEach>
		</div>
		
		<!-- 자료실 -->
		<div id="tabs-5">
		<button id="add_tab5">+</button>
			<c:forEach var="n" items="${tab5 }">
			<div class="accordion">
				<div>${n.title }</div>
				<div><a href="download?path=upload&fname=${n.filename}">${n.filename }</a>
						<img src="upload/${n.filename}">
					<div>${n.content }</div>
					<div><a href="delProc?seq=${n.seq }&tab=5">X</a></div>
				</div>
				
			</div>
			</c:forEach>
		</div>
		
		
				
		
	</div>


</body>
</html>