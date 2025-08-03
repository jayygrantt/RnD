// Fade in/out for feature sections
        function showCustomText() {
            const text = document.getElementById('customText');
            const img = document.getElementById('customizeImg');
            text.style.display = 'block';
            setTimeout(() => {
                text.style.opacity = 1;
            }, 10);
            setTimeout(() => {
                text.style.transition = 'opacity 0.5s';
                text.style.opacity = 0;
                setTimeout(() => {
                    text.style.display = 'none';
                }, 500);
            }, 3000);
        }

        function showClockText() {
            const text = document.getElementById('clockText');
            const img = document.getElementById('clockImg');
            text.style.display = 'block';
            setTimeout(() => {
                text.style.opacity = 1;
            }, 10);
            setTimeout(() => {
                text.style.transition = 'opacity 0.5s';
                text.style.opacity = 0;
                setTimeout(() => {
                    text.style.display = 'none';
                }, 500);
            }, 3000);
        }

        // Toggle more images in gallery
        function toggleMoreImages() {
            const moreImages = document.getElementById('moreImages');
            if (moreImages.style.display === 'none' || moreImages.style.display === '') {
                moreImages.style.display = 'block';
            } else {
                moreImages.style.display = 'none';
            }
        }

        document.getElementById('contactForm').addEventListener('submit', function(e) {
            e.preventDefault();
            const name = document.querySelector('input[name="name"]').value;
            const phone = document.querySelector('input[name="phone"]').value;
            const email = document.querySelector('input[name="email"]').value;
            const message = document.querySelector('textarea[name="message"]').value;
            const errorMessage = document.getElementById('errorMessage');

            // Reset error message
            errorMessage.style.display = 'none';
            errorMessage.textContent = '';

            // Validation checks
            if (name.length < 2) {
                errorMessage.textContent = 'Name must be at least 2 characters long.';
                errorMessage.style.display = 'block';
                return;
            }
            if (number.test(phone)) {
                errorMessage.textContent = 'Phone number must be exactly 10 digits.';
                errorMessage.style.display = 'block';
                return;
            }
            if (email.test(email)) {
                errorMessage.textContent = 'Please enter a valid email address.';
                errorMessage.style.display = 'block';
                return;
            }
            if (message.length < 10) {
                errorMessage.textContent = 'Message must be at least 10 characters long.';
                errorMessage.style.display = 'block';
                return;
            }

            // If validation passes, submit the form
            fetch('contact.php', {
                method: 'POST',
                body: new FormData(this)
            }).then(response => {
                if (response.ok) {
                    document.getElementById('successMessage').style.display = 'block';
                    this.reset();
                    setTimeout(() => document.getElementById('successMessage').style.display = 'none', 5000);
                }
            }).catch(error => console.error('Error:', error));
        });
const slider = document.querySelector('.slider');
        const topImage = document.querySelector('.top-image');
        const container = document.querySelector('.container');

        let isDragging = false;

        slider.addEventListener('mousedown', () => {
            isDragging = true;
        });

        document.addEventListener('mouseup', () => {
            isDragging = false;
        });

        document.addEventListener('mousemove', (e) => {
            if (!isDragging) return;

            const rect = container.getBoundingClientRect();
            let x = e.clientX - rect.left;
            x = Math.max(0, Math.min(x, rect.width));

            slider.style.left = x + 'px';
            topImage.style.clipPath = `inset(0 ${rect.width - x}px 0 0)`;
        });

        // Optional: Touch support for mobile devices
        slider.addEventListener('touchstart', () => {
            isDragging = true;
        });

        document.addEventListener('touchend', () => {
            isDragging = false;
        });

        document.addEventListener('touchmove', (e) => {
            if (!isDragging) return;

            const rect = container.getBoundingClientRect();
            let x = e.touches[0].clientX - rect.left;
            x = Math.max(0, Math.min(x, rect.width));

            slider.style.left = x + 'px';
            topImage.style.clipPath = `inset(0 ${rect.width - x}px 0 0)`;
        });