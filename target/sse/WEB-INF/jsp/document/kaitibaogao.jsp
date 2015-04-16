<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<body>
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
        'buttonText' : '上传'
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
	<!-- <div id="fileQueue"></div>
	<input type="file" name="uploadify" id="uploadify" />
	<p>
		<a href="javascript:jQuery('#uploadify').uploadifyUpload()">开始上传</a>&nbsp;
		<a href="javascript:jQuery('#uploadify').uploadifyClearQueue()">取消所有上传</a>
	</p> -->
</body>
