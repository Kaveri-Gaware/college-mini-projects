<?php
$conn = new mysqli("localhost", "root", "", "complaint_db");

if (isset($_POST['submit'])) {
    $name = $_POST['name'];
    $complaint = $_POST['complaint'];

    $conn->query("INSERT INTO complaints (name, complaint) VALUES ('$name', '$complaint')");
}
?>

<form method="post">
    Name:<br>
    <input type="text" name="name" required><br><br>

    Complaint:<br>
    <textarea name="complaint" required></textarea><br><br>

    <button name="submit">Submit</button>
</form>

<hr>

<h3>Submitted Complaints</h3>

<?php
$result = $conn->query("SELECT * FROM complaints");
while ($row = $result->fetch_assoc()) {
    echo "Name: " . $row['name'] . "<br>";
    echo "Complaint: " . $row['complaint'] . "<br>";
    echo "Status: Pending<br><hr>";
}
?>
