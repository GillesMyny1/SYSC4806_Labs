$(document).ready(function() {
    // When Create an AddressBook Link is Pressed
    $("#createBookLink").click(function(event) {
        event.preventDefault();
        $.get("/createBookUI", function(data) {
            $("body").append(data);
            // When the Create Button is Pressed
            $("#createBook").click(function() {
                $("body").children().last().hide();
            });
        });
    });

    // When Create a BuddyInfo Link is Pressed
    $("#createBuddyLink").click(function(event) {
        event.preventDefault();
        $.get("/createBuddyUI", function(data) {
            $("body").append(data);
            $("#createBuddyButton").click(function () {
                $("body").children().last().hide();
            });
        });
    });

    // When Add BuddyInfo to AddressBook Link is Pressed
    $("#addBuddyToBookLink").click(function(event) {
        event.preventDefault();
        $.get("/addBuddyToAddressBook", function(data) {
            $("body").append(data);
            $("#addBuddyToBookButton").click(function () {
                $("body").children().last().hide();
            });
        });
    });
});