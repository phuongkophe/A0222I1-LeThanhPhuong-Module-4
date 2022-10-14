<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 6/28/2022
  Time: 10:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>$Title$</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>

</head>
<body class="container">
<h1>TỜ KHAI Y TẾ</h1>
<h3>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH
    BỆNH TRUYỀN NHIỄM</h3>
<span>Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể sử lý hình sự</span>
<f:form action="/submit" method="post" modelAttribute="healthDeclaration">
    <div class="row">
        <f:label path="name">Họ tên (ghi chữ IN HOA)</f:label>
        <f:input path="name"/>
    </div>
    <div class="row">
        <div class="col">
            <f:label path="birthYear" cssClass="row">Năm sinh</f:label>
            <f:input path="birthYear"/>
        </div>
        <div class="col">
            <f:label path="gender" cssClass="row">Giới tính</f:label>
            <f:input path="gender"/>
        </div>
        <div class="col">
            <f:label path="nationality" cssClass="row">Quốc tịch</f:label>
            <f:input path="nationality"/>
        </div>
    </div>
    <div class="row">
        <f:label path="idCardNumber" cssClass="row">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</f:label>
        <f:input path="idCardNumber"/>
    </div>

    <div class="row">
        <f:label path="transportation" cssClass="row">Thông tin đi lại</f:label>
        <div class="flex flex-wrap">
            <f:checkbox path="transportation" value="Tàu bay"/> Tàu bay
            <f:checkbox path="transportation" value="Tàu thuyền"/> Tàu thuyền
            <f:checkbox path="transportation" value="Ô tô"/> Ô tô
            <f:checkbox path="transportation" value="Khác (ghi rõ)"/> Khác (ghi rõ)
        </div>
    </div>
    <div class="row">
        <div class="col">
            <f:label path="transportNumber" cssClass="row">Số hiệu phương tiện</f:label>
            <f:input path="transportNumber"/>
        </div>
        <div class="col">
            <f:label path="seatNumber" cssClass="row">Số ghế</f:label>
            <f:input path="seatNumber"></f:input>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <f:label path="departureDate" cssClass="row">Ngày khởi hành</f:label>
            <f:input path="departureDate"></f:input>
        </div>
        <div class="col">
            <f:label path="endDate" cssClass="row">Ngày kết thúc</f:label>
            <f:input path="endDate"></f:input>
        </div>
    </div>
    <div class="row">
        <f:label path="travelHistory" cssClass="row">Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào?</f:label>
        <f:input path="travelHistory"></f:input>
    </div>
    <div class="row">
        <span>Địa chỉ liên lạc</span>
        <div class="col">
            <f:label path="addressCity" cssClass="row">Tỉnh/ thành</f:label>
            <f:input path="addressCity"></f:input>
        </div>
        <div class="col">
            <f:label path="addressDistrict" cssClass="row">Quận/ huyện</f:label>
            <f:input path="addressDistrict"></f:input>
        </div>
        <div class="col">
            <f:label path="addressWard" cssClass="row">Phường/ xã</f:label>
            <f:input path="addressWard"></f:input>
        </div>
    </div>
    <div class="row">
        <f:label path="addressDetail">Địa chỉ nơi ở</f:label>
        <f:input path="addressDetail"></f:input>
    </div>
    <div class="row">
        <div class="col">
            <f:label path="phoneNumber" cssClass="row">Điện thoại</f:label>
            <f:input path="phoneNumber"></f:input>
        </div>
        <div class="col">
            <f:label path="email" cssClass="row">Email</f:label>
            <f:input path="email"></f:input>
        </div>
    </div>
    <div class="row">
        <span>Trong vòng 14 ngày qua, Anh/Chị có thấy xuất hiện dấu hiệu nào sau đây không?</span>
    </div>
    <div class="row">
        <div class="col">
            <table class="d-inline col table table-bordered">
                <tr>
                    <th>Triệu chứng</th>
                    <th>Có</th>
                    <th>Không</th>
                </tr>
                <tr>
                    <td>Sốt</td>
                    <td><f:checkbox path="symptoms" value="Sốt"/></td>
                    <td><f:checkbox path="symptoms" value=""/></td>
                </tr>
                <tr>
                    <td>Ho</td>
                    <td><f:checkbox path="symptoms" value="Ho"/></td>
                    <td><f:checkbox path="symptoms" value=""/></td>
                </tr>
                <tr>
                    <td>Khó thở</td>
                    <td><f:checkbox path="symptoms" value="Khó thở"/></td>
                    <td><f:checkbox path="symptoms" value=""/></td>
                </tr>
                <tr>
                    <td>Đau họng</td>
                    <td><f:checkbox path="symptoms" value="Đau họng"/></td>
                    <td><f:checkbox path="symptoms" value=""/></td>
                </tr>
            </table>
        </div>

        <div class="col">
            <table class="d-inline col table table-bordered">
                <tr>
                    <th>Triệu chứng</th>
                    <th>Có</th>
                    <th>Không</th>
                </tr>
                <tr>
                    <td>Nôn/buồn nôn</td>
                    <td><f:checkbox path="symptoms" value="Nôn/buồn nôn"/></td>
                    <td><f:checkbox path="symptoms" value=""/></td>
                </tr>
                <tr>
                    <td>Tiêu chảy</td>
                    <td><f:checkbox path="symptoms" value="Tiêu chảy"/></td>
                    <td><f:checkbox path="symptoms" value=""/></td>
                </tr>
                <tr>
                    <td>Xuất huyết ngoài da</td>
                    <td><f:checkbox path="symptoms" value="Xuất huyết ngoài da"/></td>
                    <td><f:checkbox path="symptoms" value=""/></td>
                </tr>
                <tr>
                    <td>Nổi ban ngoài da</td>
                    <td><f:checkbox path="symptoms" value="Nổi ban ngoài da"/></td>
                    <td><f:checkbox path="symptoms" value=""/></td>
                </tr>
            </table>
        </div>
    </div>
    <div class="row">
        <span>Lịch sử phơi nhiễm: Trong vòng 14 ngày qua, Anh/Chị có</span>
    </div>
    <div class="row">
        <table class="table table-bordered">
            <tr>
                <th></th>
                <th>Có</th>
                <th>Không</th>
            </tr>
            <tr>
                <td>Đến trang trại chăn nuôi/ chợ buôn bán động vật sống/ cơ sở giết mổ động vật/ tiếp xúc động vật</td>
                <td><f:checkbox path="exposureHistory" value="yes1"/> </td>
                <td><f:checkbox path="exposureHistory" value=""/> </td>
            </tr>
            <tr>
                <td>Tiếp xúc gần (<2m) với người mắc bệnh viêm đường hô hấp do nCoV</td>
                <td><f:checkbox path="exposureHistory" value="yes2"/></td>
                <td><f:checkbox path="exposureHistory" value=""/></td>
            </tr>
        </table>
    </div>
    <div class="row">
        Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho việc phòng chống dịch, thuộc ban quản lý của Ban chỉ đạo quốc gia về Phòng chống dịch Covid-19. Khi bạn nhấn nút "Gửi" là bạn đã hiểu và đồng ý.
    </div>
    <div>
        <button type="submit">GỬI TỜ KHAI</button>
    </div>
</f:form>
</body>

<script>

</script>
</body>
</html>
