function nobackbutton() {
    window.location.hash = "no-back-button";
    window.location.hash = "Again-No-back-button"; // Para chrome
    window.onhashchange = function () {
        window.location.hash = "no-back-button";
    };
}
