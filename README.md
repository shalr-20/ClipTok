# Cliptok

Cliptok is a prototype focused on showcasing the reel functionality, designed to display short videos with interactive playback behavior. This app allows users to scroll through videos, view profiles, and play/pause videos by interacting with them.

---

## Features
- **Fullscreen Mode:** The app operates in fullscreen, providing an immersive experience, hiding the status bar and action bar.
- **Vertical Scrolling:** Uses ViewPager to enable swipeable video pages.
- **Interactive Videos:** Tap on a video to pause/play, with automatic restart when the video ends.
- **Profile Display:** Each video is associated with a profile image and a name, mimicking a social media platform.

---

## Project Structure
The project consists of the following main classes:

**1. MainActivity** : The entry point of the app, responsible for setting up the activity layout and initializing the ViewPager for video display.

**2. Adapter** : A custom RecyclerView.Adapter that manages the list of video data (Model) and binds each video to the RecyclerView item view.

**3. Model** : A simple data model that holds the information for each video (URL, profile image, and name).

---

## How to View the Animations
Below is the demo video:

<a href="https://github.com/user-attachments/assets/7e2ac839-33e3-44f5-a694-d3d319f7f6ff" 
  alt="Watch the video">
</a>
