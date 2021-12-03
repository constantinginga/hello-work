using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualBasic;
using WebApplication.Data;
using WebApplication.Data.SavedJobListings;
using WebApplication.Models;
using Xunit;
using Xunit.Abstractions;

namespace UnitTesting
{
    public class TestingJobListings
    {
        private readonly ITestOutputHelper output;
        public TestingJobListings(ITestOutputHelper outputWriter)
        {
            output = outputWriter;
        }
        JobListingData jobListingsData = new();
        JobListing jobListing = new();
        

        [Fact]
        public async void CreatingJobListing()
        {
            jobListing.Email = "UnitTesting@gmail.com";
            jobListing.Employer = "Company";
            jobListing.JobType = "Full Time";
            jobListing.Location = "Horsens";
            jobListing.ApplicationDeadline = DateTime.Now.ToString("dd/MM/yyyy");
            jobListing.ExperienceLevel = 0;
            jobListing.JobTitle = "Software Engineer";
            jobListing.PhoneNumber = "89562356";
            jobListing.JobPrivilleges = new List<string>();
            jobListing.JobRequirments = new List<string>();
            var joblisting = jobListingsData.CreateJobListing(jobListing);
            
            var exception = await Record.ExceptionAsync(() =>
                joblisting);
            
            if (exception != null)
            {
                output.WriteLine("Throwing exception:" + exception.Message);
                Assert.IsType<Exception>(exception);
                
            }
            if (exception == null)
            {
                output.WriteLine("No exception thrown job listing was created");
            }
            
        }
        [Fact]
        public async void RemoveJobListing()
        {
            
            var joblistingtoremove = jobListingsData.GetJobListings().Result.FirstOrDefault(t => t.Email == "UnitTesting@gmail.com");
            if (joblistingtoremove == null)
            {
                output.WriteLine("Throwing exception could not find matching joblisting in database");
                Assert.Null(joblistingtoremove);
            }
            
            
            var joblisting = jobListingsData.UpdateJobListing(joblistingtoremove);
            
            
            var exception = await Record.ExceptionAsync(() =>
                joblisting);
            
            if (exception != null)
            {
                output.WriteLine("Throwing exception:"+ exception.Message);
                Assert.IsType<Exception>(exception);
                
            }
            if (exception == null)
            {
                output.WriteLine("No exception thrown job listing was removed");
            }
        }
        [Fact]
        public async void UpdateJobListing()
        {
            
            var joblistingtoupdate = jobListingsData.GetJobListings().Result.FirstOrDefault(t => t.Email == "UnitTesting@gmail.com");
            if (joblistingtoupdate == null)
            {
                output.WriteLine("Throwing exception could not find matching joblisting in database");
                Assert.Null(joblistingtoupdate);
            }
            var joblisting = jobListingsData.UpdateJobListing(joblistingtoupdate);
            
            var exception = await Record.ExceptionAsync(() =>
                joblisting);
            
            if (exception != null)
            {
                output.WriteLine("Throwing exception:"+ exception.Message);
                Assert.IsType<Exception>(exception);
                
            }
            if (exception == null)
            {
                output.WriteLine("No exception thrown job listing was updated");
            }
        }
        
    }
}