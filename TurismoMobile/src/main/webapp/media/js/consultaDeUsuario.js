let i, tabcontent, tablinks;
tabcontent = document.getElementsByClassName("tabcontent");
tablinks = document.getElementsByClassName("tablinks");


//Grab the first tab and open it
tabcontent[0].style.display = "block";
tablinks[0].classList += " selected";

function openTab(evt, tabName) {
    // Get all elements with class="tabcontent" and hide them
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    // Get all elements with class="tablinks" and remove the class "selected"
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" selected", "");
    }

    // Show the current tab, and add a "selected" class to the button that opened the tab
    document.getElementById(tabName).style.display = "block";
    document.getElementById(tabName+"-tab").classList += " selected";
}