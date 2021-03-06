<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="/inc.jsp"></jsp:include>
<style>
.input {
	width: 170px;
}
</style>
<script>
  var all_teachers_datagrid = null;
  function row_data_format(value, rowData) {
    return "<a href='javascript:void(0);' class='oneTeacherDetail' id='" + rowData['id'] + "'>" + value + "</a>";
  }
  $(function() {
    all_teachers_datagrid = $('#all_teachers_datagrid').datagrid({
      url : '${pageContext.request.contextPath}/document/allDocuments',
      fitColumns : true,
      border : false,
      nowrap : false,
      pagination : true,
      pageSize : 10,
      frozenColumns : [ [ {
        field : 'id',
        title : '用户编号',
        width : 50,
        hidden : true
      } ] ],
      columns : [ [ {
        field : 'name',
        title : '姓名',
        width : 40,
        formatter : row_data_format
      }, {
        field : 'capacity',
        title : '可接受学生数目',
        width : 40,
      }, {
        field : 'gender',
        title : '性别',
        width : 20,
        sortable : true,
      }, {
        field : 'email',
        title : '邮箱',
        width : 35,
        sortable : true,
      }, {
        field : 'phone',
        title : '电话',
        width : 55,
        sortable : true
      } ] ],
      toolbar : [ '-', {
        text : '刷新',
        iconCls : 'icon-reload',
        handler : function() {
          all_teachers_datagrid.datagrid('reload');
        }
      }, '-' ]
    });

    /* alert($("#2"));
    $(".oneTeacherDetail").each(function() {
      alert($(this).attr('id'));
    }) */

  });
</script>
</head>
<body id="shit">
	<!-- <div id="dd" title="My Dialog" style="width: 400px; height: 200px;">
	Dialog Content.</div> -->
	<div id="tab" data-options="region:'center'" style="height: 100%">
		<table id="all_teachers_datagrid"></table>
		<div></div>
	</div>
</body>



<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<body>
	<jsp:include page="/inc.jsp"></jsp:include>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery.uploadify.min.js"></script>

	<script type="text/javascript">
    $(document).ready(function() {
      $("#file_upload").uploadify({
        'swf' : '${pageContext.request.contextPath}/resources/uploadify.swf',
        'buttonText' : '浏览',
        'uploader' : '${pageContext.request.contextPath}/document/upload',
        'removeCompleted' : true,
        'fileSizeLimit' : '3MB',
        'fileTypeExts' : '*.doc; *.pdf; *.docx;',
        'cancelImg' : '${pageContext.request.contextPath}/resources/images/uploadify-cancel.png',
        'queueID' : 'fileQueue',
        'auto' : false,
        'multi' : true,
        'simUploadLimit' : 2,
        'buttonText' : 'BROWSE'
      });
    });
  </script>
	<table>
		<tr>
			<th><label for="Attachment_GUID">附件上传：</label></th>
			<td>
				<div>
					<input class="easyui-validatebox" type="hidden"
						id="Attachment_GUID" name="Attachment_GUID" /> <input
						id="file_upload" name="file_upload" type="file"
						multiple="multiple"> <a href="javascript:void(0)"
						class="easyui-linkbutton" id="btnUpload"
						data-options="plain:true,iconCls:'icon-save'"
						onclick="javascript: $('#file_upload').uploadify('upload', '*')">上传</a>

					<a href="javascript:void(0)" class="easyui-linkbutton"
						id="btnCancelUpload"
						data-options="plain:true,iconCls:'icon-cancel'"
						onclick="javascript: $('#file_upload').uploadify('cancel', '*')">取消</a>

					<div id="fileQueue" class="fileQueue"></div>
					<div id="div_files"></div>
					<br />
				</div>
			</td>
		</tr>
	</table>
</body>
 --%>