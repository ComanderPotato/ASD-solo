
const buttonEl = document.querySelector(".carSpot-button");
const pricePattern = /^\d+\.\d{2}$/;
const adminNavButtons = document.querySelectorAll(".admin-links");
const editButtons = document.querySelectorAll(".user-button--edit");
const deleteButtons = document.querySelectorAll(".user-button--delete");
adminNavButtons.forEach(link => link.addEventListener("click", toggleAdminMenu));
editButtons.forEach(editButton => editButton.addEventListener("click", openEditUserModal));
deleteButtons.forEach(deleteButton => deleteButton.addEventListener("click", openDeleteUserModal));
function openDeleteUserModal(e) {
    const dataset = e.target.parentElement.dataset;
    document.querySelector(".modal-delete").classList.remove("hidden")
    document.getElementById("deleteId").value = dataset.editid;
    document.getElementById("deleteEmail").innerText = dataset.editemail;

}
function openEditUserModal(e) {
    const dataset = e.target.parentElement.dataset;
    document.querySelector(".modal-edit").classList.remove("hidden")
    document.getElementById("editId").value = dataset.editid;
    document.getElementById("editEmail").value = dataset.editemail;
    document.getElementById("editPassword").value = dataset.editpassword;
    document.getElementById("editFirstName").value = dataset.editfirstname;
    document.getElementById("editLastName").value = dataset.editlastname;
    document.getElementById("editPhone").value = dataset.editphone;
}
function toggleAdminMenu(e) {
    if(!e.target.dataset.type) return
    const type = e.target.dataset.type;
    adminNavButtons.forEach(button => {
        const currentType = button.dataset.type
        button.toggleAttribute("disabled", currentType == type)
        document.querySelector(`.main-admin-${currentType}`).classList.toggle("hidden", currentType != type)
    })
}
document.querySelectorAll("[data-carspotinput]").forEach(input => input.addEventListener("input", checkChange))
function checkChange(e) {
    let priceCorrect = true;
    let streetNumber = true;
    let allInputs = true;
    document.querySelectorAll("[data-carspotinput]").forEach(input => {
        if(input.value.length == 0) {
            if(input.id == "streetNumber") streetNumber = false;
            else allInputs = false;
        }
        if(input.value.length > 0) {
            if(input.id == "price") {
                if (!pricePattern.test(input.value)) {
                    priceCorrect = false;
                }
            } else if(input.id == "streetNumber") {
                if(isNaN(input.value)) streetNumber = false;
            }
        }
    })
    buttonEl.toggleAttribute("disabled", !(allInputs && streetNumber && priceCorrect));
}
