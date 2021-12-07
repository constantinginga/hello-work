using System;
using System.Collections.Generic;
using System.Linq;
using WebApplication.Data;
using WebApplication.Data.SavedJobListings;
using WebApplication.Models;
using Xunit;
using Xunit.Abstractions;

namespace UnitTesting
{
    public class TestingSavedJobListings
    {
        private readonly ITestOutputHelper output;
        public TestingSavedJobListings(ITestOutputHelper outputWriter)
        {
            output = outputWriter;
        }
        SavedJobListingsData savedJobListingdata = new();
        JobListingData jobListingsData = new();
        SavedJobListing savedJobListing = new();
        JobListing jobListing = new();
        IList<JobListing> _jobListings;
        private IList<SavedJobListing> _savedJobListings;
        
        [Fact]
        public async void SavingJobListing()
        {
            _jobListings = await jobListingsData.GetJobListings();
            jobListing = _jobListings.FirstOrDefault();
            savedJobListing.Email = "UnitTestingJobSeeker@gmail.com";
            savedJobListing.Id = new Random().Next();
            savedJobListing.JobId = jobListing.JobId;
            var savedjoblist =  savedJobListingdata.CreateSavedJobListing(savedJobListing);
            
            var exception = await Record.ExceptionAsync(() =>
                savedjoblist);
            if (exception != null)
            {
                output.WriteLine("Throwing exception:" + exception.Message);
                Assert.IsType<Exception>(exception);
                
            }
            if (exception == null)
            {
                output.WriteLine("No exception thrown saving job listing to favorites was successful");
            }
        }
        [Fact]
        public async void RemovingSavedJobListing()
        {
            _savedJobListings = await savedJobListingdata.GetSavedJobListings();
            savedJobListing = _savedJobListings.FirstOrDefault(t => t.Email == "UnitTestingJobSeeker@gmail.com");

            var savedjoblist =  savedJobListingdata.RemoveSavedJobListing(savedJobListing);
            
            var exception = await Record.ExceptionAsync(() =>
                savedjoblist);
            
            if (exception != null)
            {
                output.WriteLine("Removing was not successful,Throwing exception:" + exception.Message);
                Assert.Null(exception);
            }
            output.WriteLine("No exception thrown removing  job listing from favorites was successful");
            
        }
        [Fact]
        public async void GetSavedJobListings()
        {
            var savedjoblist =  savedJobListingdata.GetSavedJobListings();
            
            var exception = await Record.ExceptionAsync(() =>
                savedjoblist);
            
            if (exception != null)
            {
                output.WriteLine("Throwing exception :" + exception.Message);
                Assert.NotNull(exception);
            }
            Assert.NotNull(savedjoblist.Result);
            output.WriteLine("No exception thrown process was successful: " + savedjoblist.Result.Count);
        }
    }
}