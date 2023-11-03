const carParkInput = document.getElementById('carPark');
const dropdown = document.querySelector(".carPark-dropdown");

carParkInput.addEventListener('input', filterCarBookings);
carParkInput.addEventListener("focusin", toggleDropdown)
carParkInput.addEventListener("focusout", toggleDropdown)
document.getElementById('state').addEventListener('change', filterCarBookings);

function toggleDropdown(e) {
    if(e.type == "focusin") {
        dropdown.classList.remove("hidden");
    } else if(e.type == "focusout") {
        dropdown.classList.add("hidden");
    }
}
function filterCarBookings(e) {
    const filterString = document.getElementById("carPark").value;
    const stateId = document.getElementById("state").value;
    dropdown.innerHTML = '';
    if(filterString == "") return;
    // Make an AJAX request to the Servlet
    const xhr = new XMLHttpRequest();
    xhr.open('POST', 'BookingPicker', true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // Handle the response from the Servlet
            const carParks = JSON.parse(xhr.responseText);

            for(let i = 0; i < carParks.length; i++) {
                markup = `
                    <div class="carPark-dropdown--item" data-carParkId="${carParks[i].id}" data-carParkName="${carParks[i].locationName}">
                        <p>${carParks[i].locationName}</p>
                        <span>${carParks[i].price}</span>
                    </div>
                `

                dropdown.insertAdjacentHTML("afterbegin", markup);
            }
            document.querySelectorAll(".carPark-dropdown--item").forEach(item =>
                item.addEventListener("click", selectCarPark)
            )
            // document.getElementById('response').innerHTML = xhr.responseText;
        }
    };

    // Send the input value to the Servlet
    const param1 = 'filterString=' + encodeURIComponent(filterString);
    const param2 = 'stateId=' + encodeURIComponent(stateId);
    const params = param1 +'&'+ param2;
    xhr.send(params);
}
function selectCarPark(e) {
    const dropdown = document.querySelector(".carPark-dropdown");
    dropdown.innerHTML = '';
    document.getElementById("carPark").value = e.target.dataset.carparkname;
    document.getElementById("carParkId").value = e.target.dataset.carparkid;

    var carParkId = document.getElementById("carParkId").value;
    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'FilterBookedDatesController', true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // Handle the response from the Servlet
            const bookedDates = JSON.parse(xhr.responseText);
            const arrivalDate = document.getElementById("arrivalDate");
            const exitDate = document.getElementById("exitDate");
            for (let i = 0; i < bookedDates.length; i++) {

            }

        }
    };

    // Send the input value to the Servlet
    var param = 'carParkId=' + encodeURIComponent(carParkId);
    xhr.send(param);
}