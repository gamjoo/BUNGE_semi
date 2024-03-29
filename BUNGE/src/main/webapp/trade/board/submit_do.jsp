<%@ page contentType="text/html;charset=utf-8" 
	import="com.oreilly.servlet.*, com.oreilly.servlet.multipart.*"
	import="java.io.*, net.trade.db.TradeDAO, net.trade.db.Trade, java.io.File"
%>
<%
request.setCharacterEncoding("utf-8");

int maxsize = 1024*1024*1024;		//최대 업로드 파일 크기(1GB)

//upload 이름을 가지는 실제 서버의 경로명 알아내기 
ServletContext context = getServletContext();
String realFolder = context.getRealPath("upload");

// 폴더 존재하는지 확인 후 없다면 생성
File folder = new File(realFolder);
if (!folder.exists()){
	folder.mkdir();
}

// 글 작성, 수정 후 redirection 할 id
int redirectId = 0;

try {
	MultipartRequest multi = new MultipartRequest(request, realFolder, 
												maxsize, "euc-kr",
												new DefaultFileRenamePolicy());

	Trade trade = new Trade();
	trade.setTitle(multi.getParameter("title"));
	trade.setSellerID(multi.getParameter("sellerID"));
	trade.setDescription(multi.getParameter("desc"));
	trade.setImageID(multi.getFile("IMAGE").getName());

	
	TradeDAO dao = new TradeDAO();
	if (multi.getParameter("tradeID") != null){	// id 의 존재 여부로 수정인지 작성인지 분기
		int id = Integer.parseInt(multi.getParameter("tradeID"));
		Trade oldTrade = dao.selectOneTradeById(tradeID);
		
		// 기존 비디오, 썸네일 경로
		File videoFile = new File(realFolder+"/"+oldTrade.getVideo());
		File thumbnailFile = new File(realFolder+"/"+oldVideo.getThumbnail());
		
		// 기존 파일 삭제
		videoFile.delete();
		thumbnailFile.delete();
		
		video.setId(id);
		repo.updateVideo(video);
		redirectId = id;
	} else {	// 작성
		redirectId = repo.insertVideo(video);
	}
	
	repo.close();
} catch(IOException e) { 
	out.println("파일 전송 오류 : " + e);
}

response.sendRedirect("view.jsp?id="+redirectId);
%>