(function() {
    var windowTrigger = document.getElementById("windowTrigger");
    windowTrigger.onclick = openWindow;

    function openWindow(event) {
        window.open("window.html", "helloAll", "location=0")
    }
})();