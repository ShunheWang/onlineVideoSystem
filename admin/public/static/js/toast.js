const Toast = Swal.mixin({
    toast: true,
    position: 'top-end',
    showConfirmButton: false,
    timer: 3000,
    timerProgressBar: true,
    didOpen: (toast) => {
      toast.addEventListener('mouseenter', Swal.stopTimer)
      toast.addEventListener('mouseleave', Swal.resumeTimer)
    }
  });
  
toast = {
    success: function(message) {
        Toast.fire({
            icon: 'success',
            title: message
        });
    },

    warning: function(message) {
        Toast.fire({
            icon: 'warning',
            title: message
        });
    },

    error: function(message) {
        Toast.fire({
            icon: 'error',
            title: message
        });
    },

}