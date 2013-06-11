(form-to [:post "/login"]
               (text-field "Username")
               (password-field "Password")
               (submit-button "Login"))

